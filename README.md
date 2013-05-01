Overview of aquaping:

Our mobile app, aquaping, attends the need for consulting, providing, and sharing information on contaminated water sources at a specific location both among individual users and interested organizations. We take a crowdsourcing approach, where anyone with a smartphone can submit reports by answering specific questions, taking a picture, and specifying the location. After processing the answers, advice regarding safe water usage is provided. 

-----

The mobile app:

Can be found inside the mobile_app folder. In order to be able to develop for both Android and iOS simultaneously, the <a href="http://www.appcelerator.com/platform/titanium-platform/">Titanium framework</a> was used.
Although at first our plan was to use <a href="http://mWater.co">mWater</a> as the base for our project, we've seen certain limitations in the way we handle data. For this reason, we've proposed our own variation of a RESTful API with the following fields:

<table>
<tr><td>Water Source</td></tr>
<tr><td>Name</td></tr>
<tr><td>Source_type_id</td></tr>
<tr><td>Description</td></tr>
<tr><td>Photo_id</td></tr>
<tr><td>Id</td></tr>
</table>

<table>
<tr><td>Notes WaterSource</td></tr>
<tr><td>Water_source_id</td></tr>
<tr><td>Id</td></tr>
<tr><td>Description</td></tr>
</table>

<table>
<tr><td>Photos water sources</td></tr>
<tr><td>Id</td></tr>
<tr><td>Photo_url</td></tr>
</table>

-----

The web service:

Found under the sendmail folder. Using the servlet technology, we developed a prototype in which we receive the information from the new report generated from the app, and we direct this information to the emails of the parties subscribed to that area. For now, it's sending all the reports to a static list.


----- 

CO2 Pollution Visualization:

Although unrelated at first sight, we worked closely with another team at the SpaceApps challenge that seeked to create useful visualizations of data. We saw a great potential in that, so we collaborated with them with future plans of expanding their idea or concept to create usseful visualizations of data into something that used the data generated from aquaping. This way, we'd make use of their concept of visualization of CO2 pollution into another field, such as water contamination.

In short, they developed a web application that aims to solve the problem that despite having much information about CO2 levels in the atmosphere, the visualization of the information is very unappealing to the people interested in it, and that don't have the required technical knowledge to analyze the data in the format in which they are.
Currently, the application allows viewing of CO2 levels, although the display must be enhanced to allow the user to interact with the application. Future work aims to improve the way you view CO2 levels as well as display the condition of the ozone layer, solar radiation levels and other data relevant to the state of the weather conditions on the planet.


----

Future work for aquaping:

At this time, even though aquaping is a working prototype, there's much work to be done. For example, a revamped webservice with a RESTful API has to be made in order to take the new input from the users. Regarding the "ticket" or reporting system, the functionality in which a party can subscribe to the reports of a certain area isn't yet implemented: the idea is to be able to subscribe by selecting a region on the map, or either by country or state.

To future versions of aquaping:

- Taking the conceptual product from the CO2 pollution visualization project, the aim is to generate visualizations of the data obtained with aquaping. One might be interested in looking at the most reported areas in a given timeframe, or perhaps the most contaminated areas in a region.

- Build a web application where anyone (environmental organizations, health departments, etc.) can subscribe to the desired region, and thereafter receiving the appropriate reports.

- Improve usability for both the iOS and Android version.
