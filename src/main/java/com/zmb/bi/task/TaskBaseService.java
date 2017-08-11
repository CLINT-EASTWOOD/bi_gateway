package com.zmb.bi.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zmb.bi.dao.TaskDao;
import com.zmb.bi.dao.TaskFlowDao;
import com.zmb.bi.persist.po.Task;
import com.zmb.bi.persist.po.TaskFlow;

@Service
public class TaskBaseService {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	private TaskFlowDao taskFlowDao;

	static int num = 0;

	public void doTask() {

		Map<String, Object> taskMap = this.doTaskPreHandle();

		if (taskMap == null) {
			return;
		}

		Task task = (Task) taskMap.get("task");
		int taskFlowId = (int) taskMap.get("taskFlowId");

		switch (task.getTaskCode()) {

		case "01":
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("CASE 01");
			break;
		case "02":
			System.out.println("CASE 02");
			break;

		default:
			break;
		}

		this.doTaskAfterHandle(taskFlowId);

		this.delayChangeExecStatusHandle(task);
	}

	@Transactional
	private Map<String, Object> doTaskPreHandle() {

		Task task = taskDao.selectAvailableTaskList();

		System.out.println(JSON.toJSONString(task));

		if (task == null) {
			return null;
		}

		task.setExecStatus(3);
		taskDao.updateByPrimaryKeySelective(task);

		TaskFlow taskFlow = new TaskFlow();
		taskFlow.setTaskCode(task.getTaskCode());
		taskFlow.setTaskName(task.getTaskName());
		taskFlow.setExecStatus(3);
		taskFlow.setTaskBeginDt(new Date());

		taskFlowDao.insert(taskFlow);

		int taskFlowId = taskFlow.getId();

		Map<String, Object> taskMap = new HashMap<String, Object>();
		taskMap.put("task", task);
		taskMap.put("taskFlowId", taskFlowId);

		return taskMap;
	}

	@Transactional
	private void doTaskAfterHandle(int taskFlowId) {

		int execStatus = 2;

		TaskFlow taskFlow = new TaskFlow();
		taskFlow.setId(taskFlowId);
		taskFlow.setExecStatus(execStatus);
		taskFlow.setTaskEndDt(new Date());

		System.out.println(JSON.toJSONString(taskFlow));

		taskFlowDao.updateByPrimaryKeySelective(taskFlow);
	}

	private void delayChangeExecStatusHandle(Task task) {

		int execStatus = 0;

		if (task.getLoop() == 0) {
			execStatus = 1;
		} else {
			execStatus = 2;
		}

		try {
			Thread.sleep(60000);
			System.out.println("Sleep 60000");
			
			Task delayChangeTask = new Task();
			delayChangeTask.setId(task.getId());
			delayChangeTask.setExecStatus(execStatus);
			
			taskDao.updateByPrimaryKeySelective(delayChangeTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
