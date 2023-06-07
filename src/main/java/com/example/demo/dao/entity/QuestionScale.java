package com.example.demo.dao.entity;

public class QuestionScale extends QuestionBase{
	private int minValue;
	private int maxValue;
	private int selectedOption = -1;

	public int select(int index) {
		if (index < minValue || index > maxValue) {
			return -1;
		}
		selectedOption = index;
		return 1;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}
}
