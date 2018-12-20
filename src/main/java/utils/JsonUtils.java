package utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
	public static final Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
			.create();
}
