package com.fly.demo.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式的实现
 *
 */
public class MediatorPatternTest {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		ConcreteColleague1 c1 = new ConcreteColleague1();
		ConcreteColleague2 c2 = new ConcreteColleague2();
		ConcreteColleague3 c3 = new ConcreteColleague3();

		mediator.register(c1);
		mediator.register(c2);
		mediator.register(c3);

		c1.send();
		System.out.println("===========");
		c2.send();
		System.out.println("===========");
		c3.send();
	}
}

abstract class Mediator {
	public abstract void register(Colleague colleague);

	// 请求转发
	public abstract void reply(Colleague colleague);
}

class ConcreteMediator extends Mediator {

	private List<Colleague> colleagues = new ArrayList<>();

	@Override
	public void register(Colleague colleague) {
		if (!colleagues.contains(colleague)) {
			colleagues.add(colleague);
			colleague.setMedium(this);
		}
	}

	@Override
	public void reply(Colleague colleague) {
		for (Colleague c : colleagues) {
			if (!c.equals(colleague)) {
				c.receive();
			}
		}
	}
}

abstract class Colleague {
	protected Mediator mediator;

	public void setMedium(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void send();

	public abstract void receive();
}

class ConcreteColleague1 extends Colleague {

	@Override
	public void receive() {
		System.out.println("具体同事类1收到请求.");

	}

	@Override
	public void send() {
		System.out.println("具体同事类1发出请求.");
		mediator.reply(this);
	}
}

class ConcreteColleague2 extends Colleague {

	@Override
	public void receive() {
		System.out.println("具体同事类2收到请求.");

	}

	@Override
	public void send() {
		System.out.println("具体同事类2发出请求.");
		mediator.reply(this);
	}
}

class ConcreteColleague3 extends Colleague {

	@Override
	public void receive() {
		System.out.println("具体同事类3收到请求.");

	}

	@Override
	public void send() {
		System.out.println("具体同事类3发出请求.");
		mediator.reply(this);
	}
}
