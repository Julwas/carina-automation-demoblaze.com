/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.myApi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/login", methodType = HttpMethodType.POST)
@Header(key = "Content-Type", value = "application/json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostLogInMethod extends AbstractApiMethodV2 {

    public PostLogInMethod() {
        super("api/users/_post/logIn_rq.json", "api/users/_post/logIn_rs.json", "api/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
