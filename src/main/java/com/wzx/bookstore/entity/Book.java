package com.wzx.bookstore.entity;

import java.util.List;

import com.wzx.bookstore.annotation.Column;
import com.wzx.bookstore.annotation.Table;
@Table("t_book")
public class Book {

	@Column("book_id")
	private int bookId;
	@Column("bookname")
	private String bookName;
	@Column("book_pub")
	private String bookPub;
    	@Column("description")
	private String description;
	@Column("category_id")
	private Category category;
	@Column("add_time")
	private String addTime;
	@Column("update_time")
	private String updateTime;
	@Column("storage")
    private int storage;
	@Column("price")
    private double price;
	private List<Picture> listBook;
	
	public Book() {
		super();
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPub() {
		return bookPub;
	}
	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Picture> getListBook() {
		return listBook;
	}
	public void setListBook(List<Picture> listBook) {
		this.listBook = listBook;
	}
	
}
