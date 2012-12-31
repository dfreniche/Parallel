#MIT License
#Diego Freniche 2012

#cccb-server.rb
#Mockup server: used to simulate a real API returning JSON data
#it does return JSON data, but always the same data. No database, no nothing. Just mocking

require 'sinatra'
require 'json'


# Making a Sinatra app respect UTF-8:
#
# 1.  At the top of your app file, set $KCODE to 'u'.
#     This ensures your regexps are in UTF-8 mode by default,
#     and #inspect will output UTF-8 chracters correctly.
#     This option is on by default as of Ruby 1.9.
#     For more information on the $KCODE setting, see:
#     http://blog.grayproductions.net/articles/the_kcode_variable_and_jcode_library
$KCODE = 'u' if RUBY_VERSION < '1.9'
 
# 2.  Set content-type with charset=utf-8 param (not the default setting.)
#     This ensures the browser will render utf-8 characters correctly.
#     A before filter is a good place to do this:
before do
  content_type :json, 'charset' => 'utf-8'
end


get '/allroutes' do

	#sleep 10

	if params[:locale] == 'ES_es'
         { :allroutes =>
             [{:id => 01, :name => 'RUTA POLÍTICA', :description => 'RUTA POLÍTICA', :timeNeeded => 30, :tags => ['one', 'two'], :pois => [
                 { :id => 01, :name => 'Caserna', :description => 'Some desc in Spanish', :latitude => 41.374966, :longitude => 2.163052, :address => 'A tocar del puerto (Pl. de les Drassanes)', :order => 10, :tags => ['I Guerra Mundial']},
                 { :id => 02, :name => 'Les 3 xemeneies', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => 'Jardins de les 3 xemeneies (av. Paral·lel 49)', :order => 20, :tags => ['Fin de la vaga canadenca']},
		{ :id => 03, :name => 'Cafè Espanyol Bar Tranquilitat', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => '', :order => 20, :tags => ['Trobades polítics']},
		{ :id => 04, :name => 'Setmana Tràgica', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => 'Teatre Apolo (av. Paral·lel 59)', :order => 20, :tags => ['Setmana Tràgica']},
		{ :id => 05, :name => 'Teatre Condal', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => '(av. Paral·lel 91)', :order => 20, :tags => ['Setmana Tràgica']},
		{ :id => 06, :name => 'Teatre Olímpia', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => 'Rda. St.  Pau – c/ Aldana', :order => 20, :tags => ['Mítings de la Guerra Civil']}

              ]},
             {:id => 02, :name => 'Ruta Urbanística', :description => 'Other desc', :timeNeeded => 60, :tags => ['one', 'two'],  :pois => [
                 { :id => 03, :name => 'Cafè Espanyol Bar Tranquilitat', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => '', :order => 20, :tags => ['Trobades polítics']}
                 ]},
             
             {:id => 03, :name => 'Ruta Friki', :description => 'Norma y sus amigos', :timeNeeded => 280, :tags => ['one', 'two'],  :pois => [
                 { :id => 03, :name => 'Cafè Espanyol Bar Tranquilitat', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => '', :order => 20, :tags => ['Trobades polítics']}
                 ]},
             {:id => 04, :name => 'Botigas Apple', :description => 'Prepara la cartera', :timeNeeded => 890, :tags => ['one', 'two'],  :pois => [
                 { :id => 03, :name => 'Cafè Espanyol Bar Tranquilitat', :description => 'Some desc in Spanish', :latitude => 42.374977, :longitude => 2.30, :address => '', :order => 20, :tags => ['Trobades polítics']}
                 ]}
             
             
             ]
         }.to_json
       
    elsif params[:locale] == 'ES_cat'
        { :id => 01, :name => 'Ruta histórica' }.to_json
    else
        { :id => 345, :key2 => 'NFTW' }.to_json
    end
    
end

get '/getroute' do
	if params[:locale] == 'ES_es'
        
        {:id => 01, :name => 'RUTA POLÍTICA', :description => 'RUTA POLÍTICA', :timeNeeded => 30, :tags => ['one', 'two'], :pois => [
                { :id => 01, :name => 'Caserna', :description => 'Some desc in Spanish', :latitude => 41.374966, :longitude => 2.163052, :address => 'A tocar del puerto (Pl. de les Drassanes)', :order => 10, :tags => ['I Guerra Mundial']},
                { :id => 02, :name => 'Les 3 xemeneies', :description => 'Some desc in Spanish', :latitude => 41.374977, :longitude => 2.17, :address => 'Jardins de les 3 xemeneies (av. Paral·lel 49)', :order => 20, :tags => ['Fin de la vaga canadenca']}
                ]
        }.to_json
        
        elsif params[:locale] == 'ES_cat'
        { :id => 01, :name => 'Ruta histórica' }.to_json
        else
        { :id => 345, :key2 => 'NFTW' }.to_json
    end
    
end



get '/poidetail' do
    content_type :json
    { :id => 01, :name => 'Ruta histórica', :description => 'Some desc in Spanish', :latitude => 10.09, :longitude => 20.09, :address => 'Parellel, 10', :order => 10, :tags => ['tag1', 'tag2'] }.to_json
end

post '/Other' do
    content_type :json
    
    { :id => 345, :key2 => 'FTW' }.to_json
end

get '/benvinguts' do
    @name = params[:name]
    content_type :html
    erb :hello
end

get '/hello/:name' do
    @name = params[:name]
    erb :hello
end



__END__
@@ layout
<html>
<body>
<%= yield %>
</body>
</html>

@@ hello
<h1 align="center">Benvingut! <%= @name %>!</h1>

