/**
 *	Copyright [2013] [www.cuubez.com]
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.cuubez.core.resource.metaData;

import java.lang.reflect.Method;
import java.util.List;


public class MethodMetaData {

	private Method reflectionMethod;
	private String path;
    private String[] consume;
	private String[] produce;
    private Class<?> clazz;
    private String httpMethod;
    private Class<?> returnType = null;
    private Class<?> inputObjectType;
    private int inputObjectIndex;
    private Object[] parameters;


	public Method getReflectionMethod() {
		return reflectionMethod;
	}
	public void setReflectionMethod(Method reflectionMethod) {
		this.reflectionMethod = reflectionMethod;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

    public String[] getConsume() {
        return consume;
    }

    public void setConsume(String[] consume) {
        this.consume = consume;
    }

    public String[] getProduce() {
        return produce;
    }

    public void setProduce(String[] produce) {
        this.produce = produce;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public int getInputObjectIndex() {
        return inputObjectIndex;
    }

    public void setInputObjectIndex(int inputObjectIndex) {
        this.inputObjectIndex = inputObjectIndex;
    }

    public Class<?> getInputObjectType() {
        return inputObjectType;
    }

    public void setInputObjectType(Class<?> inputObjectType) {
        this.inputObjectType = inputObjectType;
    }

}
