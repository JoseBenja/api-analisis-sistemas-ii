export interface Candidato {
  id: number;
  nombre_vice: string;
  imagen_url: string;
  nombre_pres: string;
  partido_politico: string;
  tipo_candidato: string;
  seleccionado: boolean;
}



export interface Voto{
  cui_votante: string;
  presidente_id: number;
  alcalde_id: number;
  diputado_lista_id: number;
  diputado_distrito_id: number;
  parlacen_id: number;
}
