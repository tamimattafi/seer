import SwiftUI
import seerCore

struct ContentView: View {
	let log = LogEntry(
        id: "12234",
        dateInMillis: 12345,
        tag: "TAG",
        level: LogLevel.DEBUG,
        description: "This is some log from iOS",
        parameters: listOf(LogParameter("testParameter", "Some Value")),
        jsonPayload: "{\"testField\":\"Test Value\"}",
        note: "Some note for log entry",
        isBookmarked: false
    )

    let logText = String(describing: log)

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}