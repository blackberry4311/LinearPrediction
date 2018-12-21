package test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.History;
import utils.JsonUtils;

//this is a api client only, if want it work concurrent, like api call, should use thread with thread pooling
public class OpenExchangeApiClient {
	public History getHistory(String date, String from, String to) throws Throwable {
		try {
			String url = String
					.format("https://openexchangerates.org/api/historical/%s.json?app_id=a196553b087444a98f17abd52b755e67&base=%s&symbols=%s",
							date, from, to);
			HttpResponse<String> response = Unirest.get(url).asString();
			int statusCode = response.getStatus();
			String body = response.getBody();
			if (statusCode == 200) {
				History history = JsonUtils.gson.fromJson(body, History.class);
				System.out.println(String.format("data for date %s from %s to %s : %s", date, from, to,
						history.getRates().get(to)));
				return history;
			} else {
				throw new Exception(String.format("StatusCode: %s, message: %s", statusCode, body));
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
		}
	}
}
