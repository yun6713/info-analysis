package com.bonc;

public class Test1 {
	public static void main(String[] args) {
		String str="docker run -p 9200:9200 -p 9300:9300 --mount type=bind,source=/share/containers/es6.4.3/config,target=/usr/share/elasticsearch/config elasticsearch:6.4.3";
		System.out.println(str);
	}
}
