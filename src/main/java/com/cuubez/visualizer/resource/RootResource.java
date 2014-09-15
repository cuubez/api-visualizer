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
package com.cuubez.visualizer.resource;

import com.cuubez.visualizer.context.ClassMetaData;
import java.util.List;

public class RootResource {

	private List<SubResource> subResources = null;
	private ClassMetaData classMetaData = null;


	public List<SubResource> getSubResources() {
		return subResources;
	}

	public void setSubResources(List<SubResource> subResources) {
		this.subResources = subResources;
	}

    public ClassMetaData getClassMetaData() {
        return classMetaData;
    }

    public void setClassMetaData(ClassMetaData classMetaData) {
        this.classMetaData = classMetaData;
    }


}
