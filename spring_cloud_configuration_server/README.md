How to run

1. commented out the security.user.password
2. start the application
3. post string password to http://localhost:8001/encrypt with password=[chosen password]
4. change security.user.password to '{cipher} [encrypted password]'
5. restart the applicatoin and log in with username : user and password: [the chosen password]
