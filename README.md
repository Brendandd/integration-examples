# Integration Examples

I currently have the following routes:

<ol>
	<li>hl7-file-input-route</li>
	<li>hl7-file-output-route</li>
	<li>mllp-input-route</li>
	<li>mllp-output-route</li>
</ol>
<br>
<br>
Each route is composed of components and a route determines the flow of a message through the components.  Depending on the type of component there can be a message acceptance policy and/or a message forwarding 
policy.  This enables components to either accept or reject messages and filter out messages before sending 
them to other components for processing.
<br>
<br>
Each example is a Spring boot application.






