package edu.mum.asd.project.fw.rulesets;

import edu.mum.asd.project.application.web.BaseController;

public interface RuleSet {
	public void applyRules(BaseController ob) throws RuleException;
}
