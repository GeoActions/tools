package com.geodev.usecase.core;

import java.util.ArrayList;
import java.util.List;

/**
 *  测试用例
 * @author geodev
 *
 */
public class UseCase {

	/**
	 * 用例标题
	 */
	private String title;
	
	/**
	 * 用例编码
	 */
    private String code;
    
    /**
     * 所属产品
     */
    private String product;
    
    /**
     * 测试类型
     */
    private String type;
    
    /**
     * 相关需求
     */
    private String requirement;
    
    /**
     * 前置条件
     */
    private String condition;
    
    /**
     * 执行过程
     */
    private List<Step> steps = new ArrayList<>();
    
    /**
     * 用例结果
     */
    private Boolean succeed;
    
    /**
     * 创建者
     */
    private String creator;
    
    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 添加执行过程
     * @param index 序号
     * @param action 操作步骤
     * @param expectation 预期结果
     * @param result 执行结果
     */
    public void addStep(int index, String action, String expectation, Boolean result) {
    	if(steps == null){
            steps = new ArrayList<>();
        }
    	steps.add(new Step(index, action, expectation, result));
    }
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Boolean getSucceed() {
		return succeed;
	}

	public void setSucceed(Boolean succeed) {
		this.succeed = succeed;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public static class Step {
    	
    	/**
    	 * 序号
    	 */
    	private Integer index;
    	
    	/**
    	 * 操作步骤
    	 */
    	private String action;
    	
    	/**
    	 * 预期结果
    	 */
    	private String expectation;
    	
    	/**
    	 * 执行结果
    	 */
    	private Boolean result;
    	
		public Step(Integer index, String action, String expectation, Boolean result) {
			this.index = index;
			this.action = action;
			this.expectation = expectation;
			this.result = result;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public String getExpectation() {
			return expectation;
		}

		public void setExpectation(String expectation) {
			this.expectation = expectation;
		}

		public Boolean getResult() {
			return result;
		}

		public void setResult(Boolean result) {
			this.result = result;
		}
    	
    }
}
