
# csEban

## Introduction
csEban is a student management system using SSM framework and Spring Cloud microservices, with Vue.js for front-end.

## Software Architecture
Typical Spring MVC architecture.

## Installation Instructions
To install csEban, follow these steps:

1. Clone the repository:
   ```bash
   git clone git@github.com:Minghao-Han/csEban.git
   ```
2. Navigate to the project directory:
   ```bash
   cd csEban
   ```
3. Check the Usage Instruction below.

## Usage Instructions
To use csEban, follow these steps:

Back-end:

1. Run your mysql server and execute /src/main/resources/db/cseban.sql. Make sure your mysql is running on 3306(the default port).
2. Open /src/main/resources/application.yml, modify the username and the password of the datasource.
3. You can simply start it by opening it in IDEA and then clicking the start button under /src/main/java/com/AAA/csEban/CsEbanApplication.java
4. Use maven to warp it into a jar package, then execute it.
5. The application will be running on 8080.

## Contributing
We welcome contributions! To contribute to csEban, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bugfix:
   ```bash
   git checkout -b Feat_xxx
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
   ```
4. Push to the branch:
   ```bash
   git push origin Feat_xxx
   ```
5. Open a Pull Request.

## License
csEban is licensed under the GPL-2.0 License. See the [LICENSE](./LICENSE) file for more details.

## Acknowledgments
[Include any acknowledgments or credits for third-party resources, collaborators, or tools used in the project.]
