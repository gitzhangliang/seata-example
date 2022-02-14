/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.examples;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaojing
 */
@RestController
public class HomeController {

	@Resource
	private  OrderService orderService;

	@Resource
	private  StorageService storageService;


	@GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
	@GetMapping(value = "/seata/feign", produces = "application/json")
	public String feign() {

		String result = storageService.storage("C00321", 2);
		if (!"SUCCESS".equals(result)) {
			throw new RuntimeException();
		}
		result = orderService.order("U100001", "C00321", 2);

		if (!"SUCCESS".equals(result)) {
			throw new RuntimeException();
		}
		return "SUCCESS";

	}

}
