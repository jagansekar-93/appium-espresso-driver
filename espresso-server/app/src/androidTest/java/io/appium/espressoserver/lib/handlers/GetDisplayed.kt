/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.espressoserver.lib.handlers

import io.appium.espressoserver.lib.handlers.exceptions.AppiumException
import io.appium.espressoserver.lib.handlers.exceptions.StaleElementException
import io.appium.espressoserver.lib.model.AppiumParams
import io.appium.espressoserver.lib.model.Element

class GetDisplayed : RequestHandler<AppiumParams, Boolean> {

    @Throws(AppiumException::class)
    override fun handle(params: AppiumParams): Boolean {
        return try {
            // either finish, throw StaleElementException, or throw NoSuchElementException
            Element.getViewInteractionById(params.elementId)
            true
        } catch (e: StaleElementException) {
            // element exists but is not displayed
            false
        }

    }
}
