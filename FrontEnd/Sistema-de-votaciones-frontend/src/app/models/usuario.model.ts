export interface Usuario {
  dpi: string;
  nombre: string;
  password: string;
  email: string;
}

export interface usuarioDTO{
username:string;
password:string;
}


export class token {
  jwt: string='';
  nombre: string='';
}
