package com.fdxdesarrollos.clientes.auth;

public class JwtConfig {
	public static final String PRIVATE_RSA = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEowIBAAKCAQEA6jhMw+5xS/skS1rjhXk1rRb7boyIGyFMivDwLoN7Lvs9uRtf\n"
			+ "PW+nZJpmYzGTXvZi2a+t4vi2kkzKd8O2JCWKjcb4jFHyA92UXvQP10pKrYYrhL60\n"
			+ "ctIL8zg1FT6b4pPJ/0vtwlECuSlg5GpJBVjnqiHBili8wK0t1Fuo5SPvO4ZatyrT\n"
			+ "zntDiaGiLv+LEd/2CLSKPmITNkzZSLE7B2wQwrI8/kJPLrpSDgGYYnEQTnZJmBAP\n"
			+ "3O6pFbpd6CeyrDQySIo2o5otfNbVXaqzNl9q/HGmEJv+gNXTh8DIvxGBK9TkTIw6\n"
			+ "h1UfIgxTrDiBh3FTN5ADPGl06vr7C8yrDijoZwIDAQABAoIBAFMeAZfyUQBusjWP\n"
			+ "nngqSHMRWc6kTlSaX4ha8lD/VcKZZBEBdq3dpqCb7kO7PxoPA4tOvb1zF48ZcyxH\n"
			+ "JqbzL5Uai+930ROwGUwM/mYfNhsYJu9noa+xfI4mXygX3MfuPFu9vTUc/INq/Lhy\n"
			+ "Q1GDeEq2yfDnhqw1iLL4iBoww1/yowPHzUUr/dNbghYcXG6XgnqRdUeczcdYdyDB\n"
			+ "SvM6GOcb5Pz+JsKiyDeZICYHhInSnGMGqosgV1MYaKddEewCN0h/tdchgwDSoeFH\n"
			+ "7jgBLX9SE+G/OXksIa+XM3jwT/Ll2L1018+o5fyHL3QiAn8udcO+gODYVxylSH/7\n"
			+ "POuheekCgYEA+MFh9TJfSHJ6ypLj3IeyAdHZnaeJg7e0JtH5+Vt1Q9SNN4o/ZhuD\n"
			+ "PPm2RSZ/Y+ual66628zeKdUZTbGX0D6MLY2lO27VtgFKCcLKoVmOb2lEKlhN+GfC\n"
			+ "S6IpXdzmURyx07K9FNKXvDeB7YrOVO8lpKyeuUAOvd9GNnj6hy2mCuUCgYEA8QqL\n"
			+ "9C9Gn6inx0o62VCwNEbWsvFIOgf3dHeoaSZSfbUbNm0vao7SnnsfOJr/N6BjW/3L\n"
			+ "ib83ULrvjJPi2vyIBxPpZDrW9S8TBfel5qXoKKq6LZoh2TouFRTQi6EKQTTW9qGE\n"
			+ "2up7NqwufK5nZ4bQ+LKWn/jXMAdU8k53sW8hVVsCgYB4GCTK0/7cYyiVFEWd+oUe\n"
			+ "C8ocKv5g8Rewhj9A+76peLyUy9G/4hiCH6y3xdZKzzxbbqgX5dh8Kb2FnO/GQew7\n"
			+ "Md9Lyj6zF/w+qiRZsXrqns+iAe/itXVAPpHqFvO6xTe1FN3kZ6eJ3uKDZDgpGSv7\n"
			+ "TLt0hFCZqmmjctTA3nEDYQKBgQC7t+n81mCa8L8RbpbcLYG8hLqqC0yjnRazRokK\n"
			+ "ssSlj8jMn0XBJ8+RivNqoxNF4AvhVYsRELDkl2D9yyJuRyMs1+34l/ZWZj3bdN1n\n"
			+ "/icKnMN3xkS8JxpCYr5zL4yL8bnDw1BzKQ+iKX/eq/ht4MmYFYVGuoXjqqIWPtPq\n"
			+ "hFCiZwKBgHNyFZgprkUux5LXGaz6lkXLIqWQekb0+Z39wTRieWTfcN5j8Ffr6waq\n"
			+ "BR7Bo6thriNTiFaVOROlygrySpR/GoaDvPGDxdBco9p2XXbA/UHG5+C2Ms8sssEP\n"
			+ "8cVhnq+tj1wDIwvwbtEBiqY+eey1yreKh0to6NmXSE2uT2+/QNaT\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String PUBLIC_RSA = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6jhMw+5xS/skS1rjhXk1\n"
			+ "rRb7boyIGyFMivDwLoN7Lvs9uRtfPW+nZJpmYzGTXvZi2a+t4vi2kkzKd8O2JCWK\n"
			+ "jcb4jFHyA92UXvQP10pKrYYrhL60ctIL8zg1FT6b4pPJ/0vtwlECuSlg5GpJBVjn\n"
			+ "qiHBili8wK0t1Fuo5SPvO4ZatyrTzntDiaGiLv+LEd/2CLSKPmITNkzZSLE7B2wQ\n"
			+ "wrI8/kJPLrpSDgGYYnEQTnZJmBAP3O6pFbpd6CeyrDQySIo2o5otfNbVXaqzNl9q\n"
			+ "/HGmEJv+gNXTh8DIvxGBK9TkTIw6h1UfIgxTrDiBh3FTN5ADPGl06vr7C8yrDijo\n"
			+ "ZwIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
	
}
