package com.zmb.bi.bean.carWash.response;

/**
 * @version		:	1.0
 * @description :	清洗车辆添加Response
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public class AddCarWashResponse {

	// 车牌号
	private String carPlateNo;
	// 汽车品牌
	private String carBrand;
	// 汽车型号
	private String carModel;
	// 汽车颜色
	private String carColor;
	
	public String getCarPlateNo() {
		return carPlateNo;
	}
	public void setCarPlateNo(String carPlateNo) {
		this.carPlateNo = carPlateNo;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
}
