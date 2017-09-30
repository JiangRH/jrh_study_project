package com.initialjiang.guavastudy.test1;

import static com.initialjiang.guavastudy.utils.MyCommonUtils.generateUUID;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.net.InternetDomainName;

/**
 * @Description Guava 库学习网站： http://www.yiibai.com/guava/guava_spliter.html
 * 
 * @Date 2017年9月30日 下午9:10:04
 * @Author rhjiang@ctrip.com Copyright (c) All Rights Reserved, 2016.
 */
public class CommanTest {

	public static void main(String[] args) {

		System.out.println(generateUUID());

		testSpliter();

		InternetDomainName owner = InternetDomainName.from("blog.takipi.com").topPrivateDomain(); // returns
		boolean isvalid = InternetDomainName.isValid("你好"); // returns false
		System.out.println("=owner============>"+owner.toString());
		System.out.println("=isvalid============>"+isvalid);

		Integer invalidInput = null;
		Preconditions.checkNotNull(invalidInput);
		Optional<Integer> a = Optional.of(invalidInput);
		Optional<Integer> b = Optional.of(new Integer(10));
		System.out.println(sum(a, b));
	}

	private static void testSpliter() {
		String msg = "the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog.";
		msg.split(",");
		System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split(msg));
		for (String element : Splitter.on(',').trimResults().omitEmptyStrings().split(msg)) {
			System.out.println(element);
		}
	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		return a.get() + b.get();
	}
}
