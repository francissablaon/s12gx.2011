/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springone2gx_2011.integration.loadbalancing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

/**
 * @author Oleg Zhurakousky
 * SpringOne2GX, Chicago 2011
 */
public class LbFailoverDemo {

	public static void main(String[] args) {
		ActiveMqTestUtils.prepare();
		ApplicationContext context = new ClassPathXmlApplicationContext("lb-config.xml", LbFailoverDemo.class);
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		inputChannel.send(new GenericMessage<String>("A"));
		inputChannel.send(new GenericMessage<String>("B"));
		inputChannel.send(new GenericMessage<String>("C"));
	}

}
