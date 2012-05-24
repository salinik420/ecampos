package pe.gob.mininter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.mininter.dao.ImagenDao;
import pe.gob.mininter.entities.SiminImagen;
import pe.gob.mininter.entities.SiminUnidadorganica;
import pe.gob.mininter.service.UsuarioService;
import pe.gob.mininter.utiles.Utiles;

@Controller
@Scope("session") 
public class UtilesController {
	
	private static final Logger logger = Logger.getLogger(UtilesController.class);
	
	@Autowired
	private UsuarioService  usuarioService;
	
	@Autowired
	ImagenDao imagenDAO;
	
	@RequestMapping("/plantilla.htm")
	 public String plantilla(ModelMap model, HttpServletRequest request) {
		return "/plantilla";
	}
	
	@RequestMapping("/menuSemanal.htm")
	 public String menuSemanal() {
		return "/menuSemanal";
	}
	
	@RequestMapping("/vision.htm")
	public String vision() {
		return "/vision";
	}
		
	@RequestMapping("/cap.htm")
	public String cap() {
		return "/cap";
	}
	
	@RequestMapping("/mof.htm")
	public String mof() {
		return "/mof";
	}	
	
	@RequestMapping("/rof.htm")
	public String rof() {
		return "/rof";
	}	
	
	@RequestMapping("/tupa.htm")
	public String tupa() {
		return "/tupa";
	}	
	
	@RequestMapping("/directivas.htm")
	public String directivas() {
		return "/directivas";
	}	
	
	@RequestMapping("/organigrama.htm")
	public String organigrama() {
		return "/organigrama";
	}	
	
	@RequestMapping("/procedimientos.htm")
	public String procedimientos() {
		return "/procedimientos";
	}
	
	@RequestMapping("/boletines.htm")
	public String boletines(ModelMap model, HttpServletRequest request) {
		model.put("imagen",new SiminImagen());
		request.getSession().setAttribute("lboletines", imagenDAO.listarImagenes(5));
		return "/boletines";
	}
	
	@RequestMapping("/buscarBol.htm")
	public String buscarBoletin(ModelMap model, HttpServletRequest request) {
		request.getSession().getAttribute("lboletines");
		model.put("imagen",new SiminImagen());
		String idBoletin = Utiles.nullToBlank(request.getParameter("coImgCodigo"));
		request.setAttribute("beanBoletin", imagenDAO.obtenerImagen(idBoletin) );
		logger.debug("pinta"+imagenDAO.obtenerImagen(idBoletin));
		return "/boletines";
	}
	
	@RequestMapping("/marcoLegal.htm")
	public String marcoLegal() {
		return "/marcoLegal";
	}
	
	@RequestMapping("/campanas.htm")
	public String campanas() {
		return "/campanas";
	}
			
	@RequestMapping("/avisosUno.htm")
	public String avisosUno() {
		return "/avisosUno";
	}
	
	@RequestMapping("/avisosDos.htm")
	public String avisosDos() {
		return "/avisosDos";
	}
	
	@RequestMapping("/avisosTres.htm")
	public String avisosTres() {
		return "/avisosTres";
	}
	
	@RequestMapping("/avisosCuatro.htm")
	public String avisosCuatro() {
		return "/avisosCuatro";
	}
	
	@RequestMapping("/galeria.htm")
	public String galeria(ModelMap model, HttpServletRequest request) {	
		model.put("listInterior", imagenDAO.listarImagenCodigo("2") );
		model.put("listDigemin", imagenDAO.listarImagenCodigo("3") );
		model.put("listDiscamec", imagenDAO.listarImagenCodigo("1") );
		return "/galeria";		
	}
	
	//no vale
	@RequestMapping("/galeriaFotos.htm")
	public String galeriaFotos(ModelMap model, HttpServletRequest request) {
		model.put("listInterior", imagenDAO.listarImagenCodigo("2") );
		model.put("listDigemin", imagenDAO.listarImagenCodigo("3") );
		model.put("listDiscamec", imagenDAO.listarImagenCodigo("1") );
		logger.debug("HOLAAAA"+imagenDAO.listarImagenCodigo("2").getNaImgNombre());
		return "/galeriaFotos";
	}
	
	@RequestMapping("/fotosCampe2011.htm")
	public String fotosCampe2011(ModelMap model, HttpServletRequest request) {
		model.put("limagenesMininter", imagenDAO.listarImagenes(2) );
		return "/fotosCampe2011";
	}
	
	@RequestMapping("/fotosDigemin.htm")
	public String fotosDigemin(ModelMap model, HttpServletRequest request) {
		model.put("limagenesDigemin", imagenDAO.listarImagenes(3) );
		return "/fotosDigemin";
	}
	
	@RequestMapping("/fotosDicscamec.htm")
	public String fotosDicscamec(ModelMap model, HttpServletRequest request ) {		
		model.put("limagenes", imagenDAO.listarImagenes(1) );
		return "/fotosDicscamec";
	}
	
	@RequestMapping("/cumplemensual.htm")
	public String lstCumpleMensual(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		request.getSession().getAttribute("usuario");		
		String meses = Utiles.nullToBlank(request.getParameter("mes"));
		String apeNombres = Utiles.nullToBlank( request.getParameter("nombres") );
	 	String[] palabras = apeNombres.split(" ");
		request.setAttribute("lcumpleaniosMensual", usuarioService.listarCumpleaniosMes("1", meses, palabras));
		logger.debug(usuarioService.listarCumpleaniosMes("1","",null).size());
		return "/lstCumple";
	}
	
	@RequestMapping("/directorioTelf.htm")
	public String lstDirectorioTelf(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		request.getSession().getAttribute("usuario");
		String descripcion = Utiles.nullToBlank(request.getParameter("nunoGeneralAbrev")).equals("-1")? Utiles.nullToBlank(request.getParameter("nunoDescripcion")) : Utiles.nullToBlank(request.getParameter("nunoGeneralAbrev"));
		model.put("oficina",new SiminUnidadorganica());
		model.put("lstOficinas", usuarioService.listarUnidadOrganica());
		request.setAttribute("ldirectorioTelf", usuarioService.listarDirectorioTelf(descripcion,"","") );
		return "/lstDirectorioTelf";
	}
}
