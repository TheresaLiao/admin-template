package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.*;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.Listen;

import java.util.*;

public class StateVM {
	private List<State> states;

	private int proof = 0;

	@Init
	public void init() {
		queryStates();
	}

	@NotifyChange({"states"})
	@Command
	public void refreshInfo() {
		queryStates();
	}

	private void queryStates() {
		proof++;
		System.out.println(proof);
		System.out.println("queryStates");
		states = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			State state = new State();
			state.setType(Type.values()[i % 4]);
			state.setValue(proof * (i + 1));
			state.setRatio(0.329);
			states.add(state);
			
			System.out.println(state.getValue());
		}
	}

	public List<State> getStates() {
		System.out.println("getStates");
		return states;
	}

}
