/**
 * 
 */
package spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.problem.Problem;

/**
 * @author skner
 *
 */
@RestController
public class SpringController {

	/**
	 * Pelo que precebi, com post ele precisa de ter o servidor ativo, e precisa de ser enviado um POST com o json (Content-Type: Application/json)
	 * O servidor spring recebe o json e coloca automaticamente numa class problem. Adiciona assim à lista que terá de ser entregue ao engine (done)
	 * 
	 * 
	 * TODO
	 * Verificar se é necessario uma classe bruta para colocar o importado do json pelo spring (possivelmente)
	 * O servidor spring fica ligado durante o processo de optimização, nao é possivel fechar o mesmo e correr o engine num outro thread
	 * Como passar o objecto JSON para o engine? A classe main corre sequencialmente e nao devolve objetos
	 * 
	 * @param problem Classe criada automaticamente pelo Spring com a estrutura do JSON
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/problem")
	public void getProblemFromJson(@RequestBody Problem problem)	{
		
	}
}
