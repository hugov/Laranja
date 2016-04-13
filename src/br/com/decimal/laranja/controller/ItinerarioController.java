package br.com.decimal.laranja.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.decimal.laranja.dao.ItinerarioDAO;
import br.com.decimal.laranja.entity.Itinerario;

@Controller
@RequestMapping("/itinerario")
public class ItinerarioController extends ControleAcessoController {

	private final String CASMODCON = "CASMODCON";
	private final String CASMODINC = "CASMODINC";
	private final String CASMODALT = "CASMODALT";
	private final String CASMODEXC = "CASMODEXC";

	@Autowired
	private ItinerarioDAO itinerarioDAO;

	@RequestMapping(value = "/lista.action")
	@ResponseBody
	public Map<String, ? extends Object> lista() {

		Map<String, Object> retorno = new HashMap<String, Object>();

		try {
			List<Itinerario> modulos = null;

			if (isAuthorizedBy(CASMODCON)) {
				modulos = itinerarioDAO.selectAll();
				retorno = getMap(modulos);
			} else {
				retorno.put("success", Boolean.FALSE);
				retorno.put("message", "Usuário sem permissão para essa operação");
			}
		} catch (Exception e) {
			retorno.put("success", Boolean.FALSE);
			retorno.put("message", "Erro na camada de persistência");
		}

		return retorno;
	}

	@RequestMapping(value = "/insert.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, ? extends Object> insert(Itinerario data) {

		Map<String, Object> retorno = new HashMap<String, Object>();

		try {

			if (isAuthorizedBy(CASMODINC)) {
				data.setIdItinerario(null);
				itinerarioDAO.insert(data);
				retorno.put("success", Boolean.TRUE);
				retorno.put("data", data);
			} else {
				retorno.put("success", Boolean.FALSE);
				retorno.put("message", "Usuário sem permissão para essa operação");
			}
		} catch (Exception e) {
			retorno.put("success", Boolean.FALSE);
			retorno.put("message", "Erro na camada de persistência");
		}

		return retorno;
	}

	@RequestMapping(value = "/update.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, ? extends Object> update(Itinerario data) {

		Map<String, Object> retorno = new HashMap<String, Object>();

		try {

			if (isAuthorizedBy(CASMODALT)) {
				itinerarioDAO.update(data);
				retorno.put("success", Boolean.TRUE);
				retorno.put("data", data);
			} else {
				retorno.put("success", Boolean.FALSE);
				retorno.put("message", "Usuário sem permissão para essa operação");
			}
		} catch (Exception e) {
			retorno.put("success", Boolean.FALSE);
			retorno.put("message", "Erro na camada de persistência");
		}

		return retorno;
	}

	@RequestMapping(value = "/delete.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, ? extends Object> delete(Itinerario data) {

		Map<String, Object> retorno = new HashMap<String, Object>();

		try {

			if (isAuthorizedBy(CASMODEXC)) {
				itinerarioDAO.delete(data.getIdItinerario().intValue());
				retorno.put("success", Boolean.TRUE);
				retorno.put("data", data);
			} else {
				retorno.put("success", Boolean.FALSE);
				retorno.put("message",
						"Usuário sem permissão para essa operação");
			}
		} catch (Exception e) {
			retorno.put("success", Boolean.FALSE);
			retorno.put("message", "Erro na camada de persistência");
		}

		return retorno;
	}

	private Map<String, Object> getMap(List<Itinerario> linhas) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", linhas.size());
		modelMap.put("data", linhas);
		modelMap.put("success", true);

		return modelMap;
	}
}
