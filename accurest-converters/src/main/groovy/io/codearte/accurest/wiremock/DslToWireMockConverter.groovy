package io.codearte.accurest.wiremock

import groovy.transform.CompileStatic
import io.codearte.accurest.dsl.GroovyDsl

@CompileStatic
abstract class DslToWireMockConverter implements SingleFileConverter {

	@Override
	boolean canHandleFileName(String fileName) {
		return fileName.endsWith('.groovy')
	}

	@Override
	String generateOutputFileNameForInput(String inputFileName) {
		return inputFileName.replaceAll('.groovy', '.json')
	}

	protected GroovyDsl createGroovyDSLfromStringContent(String groovyDslAsString) {
		return (GroovyDsl) new GroovyShell(this.class.classLoader).evaluate("$groovyDslAsString")
	}
}
