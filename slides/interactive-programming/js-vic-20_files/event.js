var EventManager = new function() {
	var eventListeners = {};

	this.listen = function(eventtype, func) {
		if (!eventListeners[eventtype]) {
			eventListeners[eventtype] = new Array();
		}
		eventListeners[eventtype].push(func);
	};

	this.event = function(event) {
		if (eventListeners[event.type]) {
			for(var i=0; i<eventListeners[event.type].length; i++) {
				eventListeners[event.type][i](event);
			}
		}
	};
};