package jedisTest;

import redis.clients.jedis.Jedis;

public class JedisDemo1 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.set("foot","bar");
		String value = jedis.get("foot");
		System.out.println(value);
	}

}
