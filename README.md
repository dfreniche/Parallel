# Parallel

## What is this

Small Android App developed to give a training workshop at CCCB Barcelona

Details: [http://www.cccb.org/lab/es/ici/apps-per-a-una-nova-cultura/]()

Este programa se utilizó para impartir un taller de desarrollo de Apps Android organizado por el CCCB en Barcelona, Sept 2012

El taller está descrito en:
http://www.cccb.org/lab/es/ici/apps-per-a-una-nova-cultura/


## To test it


- change IP Address in CCCBServerAPIWrapper, putting the IP address of the computer running Sinatra
- launch Sinatra (navigate to folder `endpoint-mockup` in a terminal). Launch `./start-sinatra.sh`
- if using Windows, you need to install Ruby 1.9 and from `endpoint-mockup` launch: ruby -rubygems cccb-server.rb 


Para probarlo:

- cambiar la dirección IP de CCCBServerAPIWrapper, por la IP del equipo que ejecute el servidor Sinatra
- iniciar sinatra (navegar a la carpeta endpoint-mockup con un terminal) y lanzar ./start-sinatra.sh
- si usamos Windows, tendremos que instalar Ruby 1.9 y desde la carpeta anterior ejecutar: ruby -rubygems cccb-server.rb 




----


License / Licencia de uso:

/*

MIT - Licence

Copyright (c) 2012 Diego Freniche

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and 
to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
DEALINGS IN THE SOFTWARE.

*/