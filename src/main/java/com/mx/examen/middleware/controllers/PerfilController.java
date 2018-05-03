package com.mx.examen.middleware.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import com.mx.examen.middleware.constantes.Codigos;
import com.mx.examen.middleware.constantes.Mensajes;
import com.mx.examen.middleware.request.PerfilRequest;
import com.mx.examen.middleware.responses.PerfilResponse;
import com.mx.examen.middleware.responses.PerfilesResponse;
import com.mx.examen.middleware.responses.Response;
import com.mx.examen.middleware.responses.ResponseWrapper;
import com.mx.examen.middleware.service.PerfilService;
import com.mx.examen.middleware.utilerias.Utilerias;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PerfilController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PerfilController.class);

	@Autowired
	private PerfilService perfilService;
	
	/**
	 * Servicio que permite obtener la Informaci&oacute;n de Perfiles de BD mongo y env&iacute;a
	 * un listado de perfiles
	 * 
	 * @return perfilesResponse <strong>perfilesResponse </strong> contiene la lista
	 *         de Perfiles as&iacute; como estado HTTP y su descripci&oacute;n
	 */
	@ApiOperation(notes = Mensajes.CONSULTA_PERFILES_SWAGGER, value = Mensajes.VALOR_PERFILES_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/perfiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response consultaPerfil() {

		LOGGER.info(Mensajes.LOG_CONSULTA_PERFILES);

		PerfilesResponse perfilesResponse = new PerfilesResponse();
		perfilesResponse.setListPerfilesResponse(perfilService.findAllPerfiles());

		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);
		respuestaServicio.setData(perfilesResponse);

		return respuestaServicio;
	}
	
	
	/**
	 * Servicio que permite obtener la Informaci&oacute;n de Perfiles de BD mongo y env&iacute;a
	 * un listado de perfiles dependiendo en patron de busqueda
	 * 
	 * @return perfilesResponse <strong>perfilesResponse </strong> contiene la lista
	 *         de Perfiles as&iacute; como estado HTTP y su descripci&oacute;n
	 */
	@ApiOperation(notes = Mensajes.CONSULTA_PERFILES_PATRON_SWAGGER, value = Mensajes.VALOR_PERFILES_PATRON_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/perfiles/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response consultaPerfilNombre(@PathVariable("nombre") String nombre) {

		LOGGER.info(Mensajes.LOG_CONSULTA_PATRON_PERFILES);

		PerfilesResponse perfilesResponse = new PerfilesResponse();
		perfilesResponse.setListPerfilesResponse(perfilService.findAllPerfiles());

		List<PerfilResponse> resultados = Utilerias.obtenInformacion(perfilesResponse.getListPerfilesResponse(),
				(PerfilResponse alumno) -> alumno.getNombre().equals(nombre));

		perfilesResponse.setListPerfilesResponse(resultados);

		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);
		respuestaServicio.setData(perfilesResponse);

		return respuestaServicio;
	}
	
	
	/**
	 * Servicio que permite realiz&aacute;r una consulta a BD-mongo
	 * 
	 * @param request define la petici&oacute;n que se realizar&aacute; al servicio
	 * 
	 *            <strong>Parametros para la B&uacute;queda del Perfil:</strong>
	 *            <li>id: del perfil que se desea eliminar</li>
	 *            </ul>
	 * 
	 * @return PerfilResponse <strong>PerfilResponse</strong> con el detalle del
	 *         perfil que se realiz&oacute; la b&uacute;squeda en BD mongo
	 *         as&iacute;&oacute; estado HTTP y su descripci&oacute;n
	 */
	@ApiOperation(notes = Mensajes.CONSULTA_PERFIL_SWAGGER, value = Mensajes.VALOR_PERFIL_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/perfil/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response consultaPerfil(@PathVariable("id") String id) {
		
		LOGGER.info(Mensajes.LOG_CONSULTA_PERFILES);

		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);
		respuestaServicio.setData(perfilService.findPerfil(id));

		return respuestaServicio;
	}
	
	/**
	 * Servicio que permite realizar la inserci&oacute;n de un perfil a BD-mongo 
	 * 
	 * @param request define la petici&oacute;n que se realizar&aacute; al servicio
	 * 
     *       	 <strong>Datos en formato JSON para la insercion de un Perfil:</strong>
	 *            <li>PerfilRequest:</li> 
	 *            <li>Nombre: del perfil que se desea insertar en Mongo </li>
	 *            <li>ApellidoPaterno: del perfil que se desea insertar en Mongo</li>
	 *            <li>ApellidoMaterno: del perfil que se desea insertar en Mongo</li>
	 *            <li>Fecha Nacimiento: del perfil que se desea insertar en Mongo en formato dd/mm/yyyy</li>
	 *            <li>Edad: del perfil que se desea insertar en Mongo</li>
	 *            <li>Foto: del perfil que se desea insertar en Mongo en Base64 </li>
	 *        </ul>
	 * @return PerfilResponse <strong>PerfilResponse</strong> con el detalle de la inserci&oacute;n en BD mongo as&iacute; estado HTTP y su descripci&oacute;n
	 * */
	@ApiOperation(notes = Mensajes.AGREGA_PERFIL_SWAGGER, value = Mensajes.VALOR_AGREGA_PERFIL_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/agregaPerfil", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response agregaPerfil(@Validated @RequestBody PerfilRequest perfilRequest) { 
		LOGGER.info(Mensajes.LOG_AGREGA_PERFIL);

		perfilService.savePerfil(perfilRequest);
		
		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);

		return respuestaServicio;
	}
	
	/**
	 * Servicio que permite realizar la actualizaci&oacute;n de un perfil a BD-mongo 
	 * 
	 * @param request define la petici&oacute;n que se realizar&oacute; al servicio
	 * 
     *       	 <strong>Datos en formato JSON para la inserci&oacute;n de un Perfil:</strong>
	 *            <li>PerfilRequest:</li> 
	 *            <li>Nombre: del perfil que se desea actualizar en Mongo </li>
	 *            <li>ApellidoPaterno: del perfil que se desea actualizar en Mongo</li>
	 *            <li>ApellidoMaterno: del perfil que se desea actualizar en Mongo</li>
	 *            <li>Fecha Nacimiento: del perfil que se desea actualizar en Mongo en formato dd/mm/yyyy</li>
	 *            <li>Edad: del perfil que se desea actualizar en Mongo</li>
	 *            <li>Foto: del perfil que se desea actualizar en Mongo en Base64 </li>
	 *        </ul>
	 * @return PerfilResponse <strong>PerfilResponse</strong> con el detalle de la realizar&oacute; en BD mongo as&iacute; estado HTTP y su descripci&oacute;n
	 * */
	@ApiOperation(notes = Mensajes.ACTUALIZAR_PERFIL_SWAGGER, value = Mensajes.VALOR_ACTUALIZAR_PERFIL_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/actualizarPerfil", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response actualizaPerfil(@Validated @RequestBody PerfilRequest perfilRequest) { 
		
		LOGGER.info(Mensajes.LOG_ACTUAIZAR_PERFIL);
		
		PerfilRequest peRequest = new PerfilRequest();
		
		PerfilResponse perfilResponse = perfilService.findPerfil(perfilRequest.getId());
				
		peRequest.setId(perfilResponse.getId());
		peRequest.setNombre(perfilResponse.getNombre());
		peRequest.setApellidoPaterno(perfilResponse.getApellidoPaterno());
		peRequest.setApellidoMaterno(perfilResponse.getApellidoMaterno());
		peRequest.setEdad(perfilResponse.getEdad());
		peRequest.setFechaNacimiento(perfilResponse.getFechaNacimiento());
		peRequest.setFoto(perfilResponse.getFoto());

		perfilService.savePerfil(perfilRequest);
		
		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);

		return respuestaServicio;
	}
	
	
	/**
	 * Servicio que permite eliminar un perfil de BD-mongo
	 * 
	 * @param request define la petici&oacute;n que se realizar&aacute; al servicio
	 * 
	 *            <strong>Parametros para la Elininaci&oacute;n del Perfil:</strong>
	 *            <li>id: del perfil que se desea eliminar</li>
	 *            </ul>
	 * @return PerfilResponse <strong>PerfilResponse</strong> con el detalle de la elininaci&oacute;n de BD mongo as&iacute; como el estado HTTP y su
	 *         descripci&oacute;n
	 */
	@ApiOperation(notes = Mensajes.ELIMINA_PERFIL_SWAGGER, value = Mensajes.VALOR_ELIMINA_PERFIL_SWAGGER, response = PerfilResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = Codigos.CODIGO_SUCCESS, message = Codigos.RESPUESTA_SUCCESS, response = PerfilResponse.class),
			@ApiResponse(code = Codigos.CODIGO_UNAUTHORIZED, message = Codigos.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = Codigos.CODIGO_FORBIDDEN, message = Codigos.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = Codigos.CODIGO_NOT_FOUND, message = Codigos.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = Codigos.CODIGO_FAILURE, message = Codigos.RESPUESTA_FAILURE) })
	@RequestMapping(path = "/eliminarPerfil/{id}", method = RequestMethod.DELETE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response eliminaPerfil(@PathVariable("id") String id) {
		
		LOGGER.info(Mensajes.LOG_ELIMINA_PERFIL);
		
		perfilService.eliminaPerfil(id);
		
		ResponseWrapper respuestaServicio = new ResponseWrapper();
		respuestaServicio.setCodigoOperacion(Codigos.EXITO);
		respuestaServicio.setMensaje(Mensajes.EXITO);

		return respuestaServicio;
	}


}
