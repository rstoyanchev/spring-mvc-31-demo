/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.mvc31.crudcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	private AccountManager accountManager;

	@Autowired
	public AccountController(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("accounts", this.accountManager.getAccounts());
		return "accounts/list";
	}

	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newForm(Model model) {
		model.addAttribute(new Account());
		return "accounts/new";
	}
	
	// The account is loaded from the "account" URI variable via {@link AccountConverter}.
	
	@RequestMapping(value="/{account}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable Account account) {
		return "accounts/edit";
	}

	// The account is loaded from the "account" URI variable via {@link AccountConverter}.
	// Data binding and validation are also applied.

	@RequestMapping(value="/{account}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "accounts/edit";
		}
		this.accountManager.saveOrUpdate(account);
		return "redirect:../accounts";
	}

	// The account is created with its default constructor.
	// Data binding and validation are also applied.

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "accounts/edit";
		}
		this.accountManager.saveOrUpdate(account);
		return "redirect:accounts";
	}

	// The account is loaded from the "account" URI variable via {@link AccountConverter}.

	@RequestMapping(value="/{account}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Account account, BindingResult result) {
		this.accountManager.delete(account);
		return "redirect:../accounts";
	}

}
