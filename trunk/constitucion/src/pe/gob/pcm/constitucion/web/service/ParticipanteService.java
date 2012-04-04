package pe.gob.pcm.constitucion.web.service;

import java.util.List;

import pe.gob.pcm.constitucion.web.model.T020tramite;
import pe.gob.pcm.constitucion.web.model.T022accionista;
import pe.gob.pcm.constitucion.web.model.T025pernat;
import pe.gob.pcm.constitucion.web.model.T026perjur;

public interface ParticipanteService {

	public List<T022accionista> listarAccionistas( int idtramite );
	public List<T022accionista> listarAccionistasCompleto(Integer numTramite);
	public List<T022accionista> listarAccionistasPersonaCompleto(Integer numTramite);
	
	public List<T025pernat> listarPersonasNaturales( int idtramite );
	public List<T026perjur> listarPersonasJuridicas( int idtramite );
	
	public void registrarAccionistas(T022accionista accionista);
	public void registrarPersonaNatural(T025pernat accionista);
	public void registrarPersonaJuridica(T026perjur accionista);
	
	public void modificarAccionistas(T022accionista accionista);
	public void modificarPersonaNatural(T025pernat accionista);
	public void modificarPersonaJuridica(T026perjur accionista);
	
	public T025pernat obtenerParticipantePn(Integer tramite, String codTipoDoc, String numDoc);
	public T026perjur obtenerParticipantePj(Integer tramite, String codTipoDoc, String numDoc);
	public T025pernat completarParticipante(T020tramite trm, T025pernat per);
	public T025pernat completarParticipanteVista(T020tramite trm, T025pernat per);
	public void eliminarParticipante(Integer cod);
	public void eliminarParticipantePn(Integer cod);
	
	public T022accionista obtenerAccionista(String numDoccon, String codTipdoc,T020tramite t020tramite);
	public T022accionista obtenerAccionista(Integer cod);
	
	
}