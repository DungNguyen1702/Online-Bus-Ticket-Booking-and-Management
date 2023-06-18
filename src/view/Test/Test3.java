package view.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 implements ActionListener{
	Test2 test2;
	public Test3(Test2 t) {
		this.test2 = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(1);
	}

}
