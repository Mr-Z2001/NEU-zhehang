package com.example.demo.dao.entity;

import java.util.List;

public class QuestionMatrix extends QuestionBase {
	private String rowDescription;
	private String columnDescription;
	private List<String> rowTitles;
	private List<String> columnTitles;
	private List<Integer> selectedCells;

	public int addRowTitle(String rowTitle) {
		if(findRowTitleByName(rowTitle) != -1) {
			return -1;
		}
		rowTitles.add(rowTitle);
		return 1;
	}

	public int removeRowTitle(int index) {
		if (index < 0 || index >= rowTitles.size()) {
			return -1;
		}
		rowTitles.remove(index);
		return 1;
	}

	public int findRowTitleByName(String rowTitleName) {
		for (int i = 0; i < rowTitles.size(); i++) {
			if (rowTitles.get(i).equals(rowTitleName)) {
				return i;
			}
		}
		return -1;
	}

	public int addColumnTitle(String columnTitle) {
		if(findColumnTitleByName(columnTitle) != -1) {
			return -1;
		}
		columnTitles.add(columnTitle);
		return 1;
	}

	public int removeColumnTitle(int index) {
		if (index < 0 || index >= columnTitles.size()) {
			return -1;
		}
		columnTitles.remove(index);
		return 1;
	}

	public int findColumnTitleByName(String columnTitleName) {
		for (int i = 0; i < columnTitles.size(); i++) {
			if (columnTitles.get(i).equals(columnTitleName)) {
				return i;
			}
		}
		return -1;
	}

	public int modifyRowTitle(int index, String rowTitle) {
		if (index < 0 || index >= rowTitles.size()) {
			return -1;
		}
		rowTitles.set(index, rowTitle);
		return 1;
	}

	public int modifyColumnTitle(int index, String columnTitle) {
		if (index < 0 || index >= columnTitles.size()) {
			return -1;
		}
		columnTitles.set(index, columnTitle);
		return 1;
	}

	public int flipSelect(int index){
		if (index < 0 || index >= rowTitles.size() * columnTitles.size()) {
			return -1;
		}
		if(selectedCells.contains(index)){
			selectedCells.remove(index);
		}else{
			selectedCells.add(index);
		}
		return 1;
	}

	public List<String> getRowTitles() {
		return rowTitles;
	}

	public void setRowTitles(List<String> rowTitles) {
		this.rowTitles = rowTitles;
	}

	public List<String> getColumnTitles() {
		return columnTitles;
	}

	public void setColumnTitles(List<String> columnTitles) {
		this.columnTitles = columnTitles;
	}

	public List<Integer> getSelectedCells() {
		return selectedCells;
	}

	public void setSelectedCells(List<Integer> selectedCells) {
		this.selectedCells = selectedCells;
	}

	public String getRowDescription() {
		return rowDescription;
	}

	public void setRowDescription(String rowDescription) {
		this.rowDescription = rowDescription;
	}

	public String getColumnDescription() {
		return columnDescription;
	}

	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}


}
