package com.aem.bala.core.services;

import java.io.IOException;

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

public interface CsvCreatingPage {
	public int createPage() throws IOException, ValueFormatException, VersionException, LockException, ConstraintViolationException, RepositoryException;
}
