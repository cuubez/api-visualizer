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
package com.cuubez.visualizer.resource.domain;

import com.cuubez.visualizer.context.HttpCodeMetaData;

import java.util.List;

public class RootResource {

	private String path;
    private String name;
    private String detail;
    private String[] consume;
    private String[] produce;
    private Class<?> clazz;
    private List<HttpCodeMetaData> httpCodeMetaDataList;
    private List<SubResource> subResources = null;


    public List<SubResource> getSubResources() {
		return subResources;
	}

	public void setSubResources(List<SubResource> subResources) {
		this.subResources = subResources;
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

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<HttpCodeMetaData> getHttpCodeMetaDataList() {
        return httpCodeMetaDataList;
    }

    public void setHttpCodeMetaDataList(List<HttpCodeMetaData> httpCodeMetaDataList) {
        this.httpCodeMetaDataList = httpCodeMetaDataList;
    }


}
