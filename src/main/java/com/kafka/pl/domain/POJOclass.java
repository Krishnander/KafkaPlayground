package com.kafka.pl.domain;

public class POJOclass {

	String name;
	String job;

	public POJOclass() {
		super();
	}

	public POJOclass(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "POJOClass [name=" + name + ", job=" + job + "]";
	}

}