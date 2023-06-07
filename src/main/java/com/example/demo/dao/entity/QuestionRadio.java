package com.example.demo.dao.entity;

import java.util.List;

public class QuestionRadio extends QuestionBase {
	private List<String> options;
	private int selectedOption = -1;

	public int addOption(String option) {
		if(findOptionByName(option) != -1) {
			return -1;
		}
		options.add(option);
		return 1;
	}

	public int removeOption(int index) {
    if (index < 0 || index >= options.size()) {
      return -1;
		}
		options.remove(index);
		return 1;
	}

	public int findOptionByName(String optionName) {
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).equals(optionName)) {
				return i;
			}
		}
		return -1;
	}

	public int select(int index) {
		if (index < 0 || index >= options.size()) {
			return -1;
		}
		selectedOption = index;
		return 1;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}
}
