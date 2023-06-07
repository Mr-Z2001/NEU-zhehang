package com.example.demo.dao.entity;

import java.util.List;

public class QuestionCheckBox extends QuestionBase {
	private List<String> options;
	private List<Integer> selectedOptions;

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

	public int flipSelect(int index){
		if (index < 0 || index >= options.size()) {
			return -1;
		}
		if(selectedOptions.contains(index)){
			selectedOptions.remove(index);
		}else{
			selectedOptions.add(index);
		}
		return 1;
	}

	public int modifyOption(int index, String option) {
		if (index < 0 || index >= options.size()) {
			return -1;
		}
		options.set(index, option);
		return 1;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<Integer> getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(List<Integer> selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

}
