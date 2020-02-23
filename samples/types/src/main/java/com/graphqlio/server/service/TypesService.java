/**
 * *****************************************************************************
 *
 * <p>Design and Development by msg Applied Technology Research Copyright (c) 2019-2020 msg systems
 * ag (http://www.msg-systems.com/) All Rights Reserved.
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * <p>****************************************************************************
 */
package com.graphqlio.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.graphqlio.server.resolvers.RootMutationResolver;
import com.graphqlio.server.resolvers.RootQueryResolver;
import com.graphqlio.server.server.GsServer;

/**
 * Service responsible for starting GraphQLIO Server and registering the GraphQL application resolvers
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 * @author Dr. Edgar Müller
 */

@Service
public class TypesService implements ApplicationRunner {
	
	
	@Autowired
	RootQueryResolver queryResolver;

	@Autowired
	RootMutationResolver mutationResolver;

	@Autowired
	private GsServer gsServer;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {	
		
		gsServer.registerGraphQLResolver(queryResolver);
		gsServer.registerGraphQLResolver(mutationResolver);
		gsServer.start();		
	}
}
