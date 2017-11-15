#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 21 20:43:27 2017

@author: Paulo Andrade
"""

import sympy as sp
 
class GausJordan:
	def __init__(self, a=[], b=False):
		"""
		Recibimos las dos matrices, la matriz b obtiene el valor False,
		en caso de querer obtener la inversa
		"""

		self.a = a # Matriz a
		self.b = b # Matriz b


	def idMatx(self, size):
		"""
		"""

		id = []
		for i in range(size):
			id.append([0]*size)


		for i in range(size):
			id[i][i] = 1


		return id
 
	def tranMtx(self, inMtx):
		"""
		"""

		tMtx = []
		for row in range(0, len(inMtx[0])):
			tRow = []
			for col in range(0, len(inMtx)):
				ele = inMtx[col][row]
				tRow.append(ele)
			tMtx.append(tRow)


		return tMtx
 
	def matxRound(self, matx, decPts=4):
		"""
        Redondeamos los decimales mediante decPts
		"""

		for col in range(len(matx)):
			for row in range(len(matx[0])):
				matx[col][row] = round(matx[col][row], decPts)

		self.m = matx
 
	# the solver ...
	def gj_Solve(self, A, b=False, decPts=4):
		""" A gauss-jordan method to solve an augmented matrix for
		  the unknown variables, x, in Ax = b.
		  The degree of rounding is 'tuned' by altering decPts = 4.
		  In the case where b is not supplied, b = ID matrix, and therefore
		  the output is the inverse of the A matrix.
		"""
	 
		if not b == False:
			# first, a test to make sure that A and b are conformable
			if (len(A) != len(b)):
				print 'A and b are not conformable'
				return []
			Ab = A[:]
			Ab.append(b)
			self.m = self.tranMtx(Ab)
		else:
			ii = self.idMatx(len(A))
			Aa = A[:]
			for col in range(len(ii)):
				Aa.append(ii[col])
			tAa = self.tranMtx(Aa)
			self.m = tAa[:]
	 
		(eqns, colrange, augCol) = (len(A), len(A), len(self.m[0]))
	 
		# permute the matrix -- get the largest leaders onto the diagonals
		# take the first row, assume that x[1,1] is largest, and swap if that's not true
		for col in range(0, colrange):
			bigrow = col
			for row in range(col+1, colrange):
				if abs(self.m[row][col]) > abs(self.m[bigrow][col]):
					bigrow = row
					(self.m[col], self.m[bigrow]) = (self.m[bigrow], self.m[col])
		#print 'm is ', self.m # Mostramos el contenido de m
	 
		# reduce, such that the last row is has at most one unknown
		for rrcol in range(0, colrange):
			for rr in range(rrcol+1, eqns):
				cc = -(sp.Float(self.m[rr][rrcol])/sp.Float(self.m[rrcol][rrcol]))
				for j in range(augCol):
					self.m[rr][j] = self.m[rr][j] + cc*self.m[rrcol][j]
	 
		# final reduction -- the first test catches under-determined systems
		# these are characterised by some equations being all zero
		for rb in reversed(range(eqns)):
			if ( self.m[rb][rb] == 0):
				if self.m[rb][augCol-1] == 0:
					continue
				else:
					print 'system is inconsistent'
					return []
			else:
				# you must loop back across to catch under-determined systems
				for backCol in reversed(range(rb, augCol)):
					self.m[rb][backCol] = sp.Float(self.m[rb][backCol]) / sp.Float(self.m[rb][rb])
				# knock-up (cancel the above to eliminate the knowns)
				# again, we must loop to catch under-determined systems
				if not (rb == 0):
					for kup in reversed(range(rb)):
						for kleft in reversed(range(rb, augCol)):
							kk = -sp.Float(self.m[kup][rb]) / sp.Float(self.m[rb][rb])
							self.m[kup][kleft] += kk*sp.Float(self.m[rb][kleft])
	 
		#self.matxRound(self.m, decPts)
	 
		if not b == False:
			return self.m
		else:
			mOut = []
			for row in range(len(self.m)):
				rOut = []
				for col in range(augCol/2, augCol):
					rOut.append(self.m[row][col])
				mOut.append(rOut)
			return mOut

	def solve(self, A, b=False):
		"""
		Obtenemos las soluciones
		"""

		# Obtenemos la matriz solucion
		res = self.gj_Solve(A, b);
		sol = []

		# verificamos que sea una solucion
		if len(res) != 0 :
			# Obtenemos las soluciones
			for i in range(0, len(res)) :
				sol.append(res[i][len(res)])

		return sol
			

 
# test it!
if __name__ == "__main__":
	A = [[1,2,4,3],
		[1,3,0,3],
		[1,5,5,3],
		[3,5,6,7]]
 
	b = [5,8,2,4]

	gj = GausJordan()
	print gj.solve(A, b)

	#sol = gj_Solve(A, b)
	#print 'sol is ', sol
	 
	#inv = gj_Solve(A)
	#print 'inv is ', inv