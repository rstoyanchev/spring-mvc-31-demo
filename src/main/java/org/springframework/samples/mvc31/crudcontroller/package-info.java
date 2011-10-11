
/**
 * A controller to list, create, edit, update and delete accounts. 
 * Some operations expect a URI variable (e.g. update, delete) containing the account 
 * number while others don't (e.g. create). Therefore a single @ModelAttribute method
 * to add the account to the model before all operations won't work.
 * 
 * <p>This controller shows use of @PathVariable and @ModelAttribute arguments along 
 * with a {@link org.springframework.core.convert.converter.Converter} to load the 
 * Account from its account number.
 * 
 * <p>For @PathVariable arguments, a URI variable is used to load the Account. 
 * For @ModelAttribute, a URI variable is used if it is available and also data 
 * binding is applied.
 * 
 */
package org.springframework.samples.mvc31.crudcontroller;

