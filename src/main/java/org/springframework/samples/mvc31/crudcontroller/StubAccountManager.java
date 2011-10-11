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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StringUtils;

public class StubAccountManager implements AccountManager {

	private final Map<String, Account> accounts;

	private final AtomicInteger nextNumber = new AtomicInteger(3);

	public StubAccountManager() {
		this.accounts = new HashMap<String, Account>();
		addAccount("a1", "Jay");
		addAccount("a2", "Jason");
		addAccount("a3", "Julie");
	}

	private void addAccount(String number, String name) {
		this.accounts.put(number, new Account(number, name));
	}

	@Override
	public List<Account> getAccounts() {
		return new ArrayList<Account>(this.accounts.values());
	}

	@Override
	public Account getAccount(String number) {
		Account account = this.accounts.get(number);
		if (account == null) {
			throw new AccountNotFoundException(number);
		}
		return account;
	}

	@Override
	public void saveOrUpdate(Account account) {
		if (!StringUtils.hasText(account.getNumber())) {
			account.setNumber(getNextNumber());
		}
		this.accounts.put(account.getNumber(), account);
	}

	private String getNextNumber() {
		return "a" + this.nextNumber.incrementAndGet();
	}

	@Override
	public void delete(Account account) {
		this.accounts.remove(account.getNumber());
	}

}
