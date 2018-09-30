package com.solo.web.adaptor;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaojian
 * @Date 2018/9/25
 */
@Component
public class SentinelAdaptor {

    public String get() {
        /*//配置该资源的规则
        initFlowRules();
        Entry entry = null;
        try {
            entry = SphU.entry("testGet");
        } catch (BlockException e) {
            System.out.println("block!");
        } finally {
            if(entry != null){
                entry.exit();
            }
        }*/
        return "hello";
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource("testGet");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(5);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
