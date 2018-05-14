package edu.mum.asd.project.fw.notify;

public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
