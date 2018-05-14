package edu.mum.asd.project.fw.rulesets;

import java.util.HashMap;

import edu.mum.asd.project.application.web.BaseController;
import edu.mum.asd.project.application.web.LoginController;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends BaseController>, RuleSet> map = new HashMap<>();
	static {
		map.put(LoginController.class, new LoginControllerRuleSet());
	}
	public static RuleSet getRuleSet(BaseController c) {
		Class<? extends BaseController> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
