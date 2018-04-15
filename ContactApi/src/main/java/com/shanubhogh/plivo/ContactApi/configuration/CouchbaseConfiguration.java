package com.shanubhogh.plivo.ContactApi.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@EnableCouchbaseRepositories(basePackages={"com.shanubhogh.plivo.ContactApi.configuration"})
@Configuration

public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
	@Value("${couchbase.cluster.bucketName}")
	private String bucketName;
	
	@Value("${couchbase.cluster.ip}")
	private String ip;
	
	@Value("${couchbase.cluster.password:}")
	private String password;
	public CouchbaseConfiguration(){}

	public CouchbaseConfiguration(String bucketName, String password, String ip) {
		this.bucketName = bucketName;
		this.password = password;
		this.ip = ip;
	}
	
	@Override
	protected String getBucketName() {
		return bucketName;
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(ip);
	}
}