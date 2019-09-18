package com.geodev.usecase;

import com.geodev.usecase.core.Document;
import com.geodev.usecase.core.UseCase;

public class Application {

	public static void main(String[] args) {
		UseCase useCase = new UseCase();
		useCase.setTitle("验证新建项目功能正确性");
		useCase.setCode("TEST001");
		useCase.setProduct("项目管理 V2.0");
		useCase.setType("功能测试");
		useCase.setRequirement("新建项目");
		useCase.setCondition("用户已登录");
		useCase.addStep(1, "点击项目列表下拉菜单", "展示新建项目按钮", true);
		useCase.addStep(2, "点击新建项目", "弹出新建项目页面", true);
		useCase.addStep(3, "输入名称，点击保存", "提示保存成功", true);
		useCase.addStep(4, "点击项目列表下拉菜单", "显示新建的项目", true);
		useCase.setSucceed(true);
		useCase.setCreator("李蕾");
		useCase.setCreateTime("2019-09-18");
		
		Document document = new Document();
		document.addUseCase(useCase);
		document.addUseCase(useCase);
		document.addUseCase(useCase);
		document.addUseCase(useCase);
		document.addUseCase(useCase);
		document.generate();
	}

}
